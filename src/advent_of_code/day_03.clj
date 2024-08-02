(ns advent-of-code.day-03
  (:require [clojure.string :as str])
  (:require [clojure.set :as set]))

(defn split-half [s]
  (let [len (count s)] (split-at (/ len 2) s)))

(defn intersect-sacks [s] 
  (let [[lhs rhs] (split-half s)
        _ (println lhs rhs) ]
    (seq (set/intersection (set lhs) (set rhs))) ))

(defn intersect-sacks2 [s]
  (let [sacks (split-half s)] 
    (->> (map #(apply set/intersection (map set %)) sacks)
         (apply concat))))

(defn calc-score [ch]
  (let [asciic (int ch)]
    (if (Character/isLowerCase ch)
      (inc (- asciic (int \a))) 
      (inc (+ 26 (- asciic (int \A)))))))

(defn part-1
  "Day 03 Part 1"
  [input]
  (->> (str/split-lines input)
       (map intersect-sacks)
       (map #(apply calc-score %))
       (apply +)))

(defn part-2
  "Day 03 Part 2"
  [input]
  (->> (partition 6 (str/split-lines input))
       (map intersect-sacks2)
       (apply concat)
       (map calc-score)
       (apply +)))
