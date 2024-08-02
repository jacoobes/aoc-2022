(ns advent-of-code.day-02
  (:require [ clojure.string :as str]))

; any option beats the option in the index that comes before it, ties with the option at the same index, and loses to the option in the next index
; there's a very elegant way of representing this using just math you can look into once you get this method working
; keep in mind this is circular, because rock beats paper as well. thats why we have to modulo and ensure positive
(def rps-scores { "A" 1 "B" 2 "C" 3 
                  "X" 1 "Y" 2 "Z" 3 })

(def match-scores { 0 3    ; draw
                    1 6 }) ; win

(defn calculate-scores [[op me]]
  (let [result (mod (- me op +3) 3)] 
    (+ me (match-scores result 0))))

(defn part-1
  "Day 02 Part 1"
  [input]
  (->> (map #(str/split % #" ") (str/split-lines input)) 
       (map #(map rps-scores %))
       (map calculate-scores)
       (reduce +)))

(defn calculate-scores-foreal [[op me]]
  (let [op-sc (rps-scores op)
        me-sc (rps-scores me)]
    (case me "X" (calculate-scores [op-sc (inc op-sc)])    ; must lose
             "Y" (calculate-scores [op-sc op-sc])          ;must draw
             "Z" (calculate-scores [op-sc (dec op-sc)])))) ; must win

(defn part-2
  "Day 02 Part 2"
  [input]
  (->> (map #(str/split % #" ") (str/split-lines input))
       (map calculate-scores-foreal)
       ))
