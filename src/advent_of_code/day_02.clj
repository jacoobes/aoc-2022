(ns advent-of-code.day-02
  (:require [ clojure.string :as str]))

; any option beats the option in the index that comes before it, ties with the option at the same index, and loses to the option in the next index
; there's a very elegant way of representing this using just math you can look into once you get this method working
; keep in mind this is circular, because rock beats paper as well. thats why we have to modulo and ensure positive
(def rps-scores { "A" 1 "B" 2 "C" 3 
                  "X" 1 "Y" 2 "Z" 3 })
(def rev { 1 "A" 2 "B" 3 "C" })
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

(def winmap { 1 2
              2 3
              3 1 })

(def losemap { 1 3 
               2 1 
               3 2 })

(defn calculate-scores-foreal [[op me]]
  (let [op-sc (rps-scores op)
        result (case me "X"  (losemap op-sc)      ;lose
                        "Y"  op-sc                 ;draw
                        "Z"  (winmap op-sc))] ;win
    (println "op " op "   " op-sc  "result " me "  " result  "  =" (calculate-scores [op-sc result]  ))
    (calculate-scores [op-sc result])))

(defn part-2
  "Day 02 Part 2"
  [input]
  (->> (map #(str/split % #" ") (str/split-lines input))
       #_(take 15)
       (map calculate-scores-foreal)
       (reduce +)))
