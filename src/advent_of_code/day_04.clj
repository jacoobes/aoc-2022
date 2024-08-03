(ns advent-of-code.day-04
  (:require [clojure.string :as str]))

(defn inclusive-range [[start end]] 
    (range start (inc end)))

(defn num-in [rang num]
  (not= -1 (.indexOf rang num)))

; if range1 end greater than range2 start or viceversa
(defn overlaps? [range1 range2]
  (cond (or (empty? range1) (empty? range2)) false
        :else (or (num-in range1 (first range2))
                  (num-in range1 (last range2))
                  (num-in range2 (last range1))
                  (num-in range2 (first range1)))))

(defn contains-rng [range1 range2]
  (cond (empty? range1) false
        (empty? range2) false
        :else (or (and (num-in range2 (first range1)) 
                       (num-in range2 (last range1)))
                  (and (num-in range1 (first range2)) 
                       (num-in range1 (last range2))))))

(defn parse-range [s]
  (let [ranges (map #(str/replace % #"-" " ") (str/split s #","))]
    (map #(inclusive-range (read-string (str "[" % "]"))) ranges)))

(defn part-1
  "Day 04 Part 1"
  [input]
  (->> (str/split-lines input)
       (map parse-range)
       (map #(apply contains-rng %))
       (filter true?)
       (count)))

(defn part-2
  "Day 04 Part 2"
  [input]
  (->> (str/split-lines input)
       (map parse-range)
       (map #(apply overlaps? %))
       (filter true?)
       (count)))
