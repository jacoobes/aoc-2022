(ns advent-of-code.day-01
  (:require [clojure.string :as str]))


(defn get-nums [input]
  (->> (str/split input #"\r?\n")
       (partition-by str/blank?)
       (map #(reduce + (map clojure.edn/read-string %)))
       (filter some?)))
(defn part-1
  "Day 01 Part 1"
  [input]
  (apply (get-nums input) max))

(defn part-2
  "Day 01 Part 2"
  [input] (apply + (take 3 (sort > (get-nums input)))))
