(ns advent-of-code.core
  (:require [advent-of-code.day-01]
            [advent-of-code.day-02]
            [advent-of-code.day-03]
            [advent-of-code.day-04]
            [advent-of-code.day-05]
            [advent-of-code.day-06]
            [advent-of-code.day-07]
            [advent-of-code.day-08]
            [advent-of-code.day-09]
            [advent-of-code.day-10]
            [advent-of-code.day-11]
            [advent-of-code.day-12]
            [advent-of-code.day-13]
            [advent-of-code.day-14]
            [advent-of-code.day-15]
            [advent-of-code.day-16]
            [advent-of-code.day-17]
            [advent-of-code.day-18]
            [advent-of-code.day-19]
            [advent-of-code.day-20]
            [advent-of-code.day-21]
            [advent-of-code.day-22]
            [advent-of-code.day-23]
            [advent-of-code.day-24]
            [advent-of-code.day-25]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "Used to dispatch tasks from the command line.
  
  lein run d01.p1"
  [part & rst]
  (case part
    "d01.p1" (println (advent-of-code.day-01/part-1 (read-input (str "day-01" (first rst) ".txt"))))
    "d01.p2" (println (advent-of-code.day-01/part-2 (read-input (str "day-01" (first rst) ".txt"))))
    "d02.p1" (println (advent-of-code.day-02/part-1 (read-input (str "day-02" (first rst) ".txt"))))
    "d02.p2" (println (advent-of-code.day-02/part-2 (read-input (str "day-02" (first rst) ".txt"))))
    "d03.p1" (println (advent-of-code.day-03/part-1 (read-input (str "day-03" (first rst) ".txt"))))
    "d03.p2" (println (advent-of-code.day-03/part-2 (read-input (str "day-03" (first rst) ".txt"))))
    "d04.p1" (println (advent-of-code.day-04/part-1 (read-input (str "day-04" (first rst) ".txt"))))
    "d04.p2" (println (advent-of-code.day-04/part-2 (read-input (str "day-04" (first rst) ".txt"))))
    "d05.p1" (println (advent-of-code.day-05/part-1 (read-input (str "day-05" (first rst) ".txt"))))
    "d05.p2" (println (advent-of-code.day-05/part-2 (read-input (str "day-05" (first rst) ".txt"))))
    "d06.p1" (println (advent-of-code.day-06/part-1 (read-input (str "day-06" (first rst) ".txt"))))
    "d06.p2" (println (advent-of-code.day-06/part-2 (read-input (str "day-06" (first rst) ".txt"))))
    "d07.p1" (println (advent-of-code.day-07/part-1 (read-input (str "day-07" (first rst) ".txt"))))
    "d07.p2" (println (advent-of-code.day-07/part-2 (read-input (str "day-07" (first rst) ".txt"))))
    "d08.p1" (println (advent-of-code.day-08/part-1 (read-input (str "day-08" (first rst) ".txt"))))
    "d08.p2" (println (advent-of-code.day-08/part-2 (read-input (str "day-08" (first rst) ".txt"))))
    "d09.p1" (println (advent-of-code.day-09/part-1 (read-input (str "day-09" (first rst) ".txt"))))
    "d09.p2" (println (advent-of-code.day-09/part-2 (read-input (str "day-09" (first rst) ".txt"))))
    "d10.p1" (println (advent-of-code.day-10/part-1 (read-input (str "day-10" (first rst) ".txt"))))
    "d10.p2" (println (advent-of-code.day-10/part-2 (read-input (str "day-10" (first rst) ".txt"))))
    "d11.p1" (println (advent-of-code.day-11/part-1 (read-input (str "day-11" (first rst) ".txt"))))
    "d11.p2" (println (advent-of-code.day-11/part-2 (read-input (str "day-11" (first rst) ".txt"))))
    "d12.p1" (println (advent-of-code.day-12/part-1 (read-input (str "day-12" (first rst) ".txt"))))
    "d12.p2" (println (advent-of-code.day-12/part-2 (read-input (str "day-12" (first rst) ".txt"))))
    "d13.p1" (println (advent-of-code.day-13/part-1 (read-input (str "day-13" (first rst) ".txt"))))
    "d13.p2" (println (advent-of-code.day-13/part-2 (read-input (str "day-13" (first rst) ".txt"))))
    "d14.p1" (println (advent-of-code.day-14/part-1 (read-input (str "day-14" (first rst) ".txt"))))
    "d14.p2" (println (advent-of-code.day-14/part-2 (read-input (str "day-14" (first rst) ".txt"))))
    "d15.p1" (println (advent-of-code.day-15/part-1 (read-input (str "day-15" (first rst) ".txt"))))
    "d15.p2" (println (advent-of-code.day-15/part-2 (read-input (str "day-15" (first rst) ".txt"))))
    "d16.p1" (println (advent-of-code.day-16/part-1 (read-input (str "day-16" (first rst) ".txt"))))
    "d16.p2" (println (advent-of-code.day-16/part-2 (read-input (str "day-16" (first rst) ".txt"))))
    "d17.p1" (println (advent-of-code.day-17/part-1 (read-input (str "day-17" (first rst) ".txt"))))
    "d17.p2" (println (advent-of-code.day-17/part-2 (read-input (str "day-17" (first rst) ".txt"))))
    "d18.p1" (println (advent-of-code.day-18/part-1 (read-input (str "day-18" (first rst) ".txt"))))
    "d18.p2" (println (advent-of-code.day-18/part-2 (read-input (str "day-18" (first rst) ".txt"))))
    "d19.p1" (println (advent-of-code.day-19/part-1 (read-input (str "day-19" (first rst) ".txt"))))
    "d19.p2" (println (advent-of-code.day-19/part-2 (read-input (str "day-19" (first rst) ".txt"))))
    "d20.p1" (println (advent-of-code.day-20/part-1 (read-input (str "day-20" (first rst) ".txt"))))
    "d20.p2" (println (advent-of-code.day-20/part-2 (read-input (str "day-20" (first rst) ".txt"))))
    "d21.p1" (println (advent-of-code.day-21/part-1 (read-input (str "day-21" (first rst) ".txt"))))
    "d21.p2" (println (advent-of-code.day-21/part-2 (read-input (str "day-21" (first rst) ".txt"))))
    "d22.p1" (println (advent-of-code.day-22/part-1 (read-input (str "day-22" (first rst) ".txt"))))
    "d22.p2" (println (advent-of-code.day-22/part-2 (read-input (str "day-22" (first rst) ".txt"))))
    "d23.p1" (println (advent-of-code.day-23/part-1 (read-input (str "day-23" (first rst) ".txt"))))
    "d23.p2" (println (advent-of-code.day-23/part-2 (read-input (str "day-23" (first rst) ".txt"))))
    "d24.p1" (println (advent-of-code.day-24/part-1 (read-input (str "day-24" (first rst) ".txt"))))
    "d24.p2" (println (advent-of-code.day-24/part-2 (read-input (str "day-24" (first rst) ".txt"))))
    "d25.p1" (println (advent-of-code.day-25/part-1 (read-input (str "day-25" (first rst) ".txt"))))
    "d25.p2" (println (advent-of-code.day-25/part-2 (read-input (str "day-25" (first rst) ".txt"))))
    (println "not found:" part)))

