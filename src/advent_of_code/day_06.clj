(ns advent-of-code.day-06)

(defn decode-stream [st mark]
  (loop [[[i ch] & rst] (map-indexed vector st) ]
    (if (= mark (count (distinct (cons ch (map second (take (dec mark) rst))))))
      (+ mark i) 
      (recur rst))))

(defn part-1
  "Day 06 Part 1"
  [input] (decode-stream input 4))

(defn part-2
  "Day 06 Part 2"
  [input] (decode-stream input 14))
