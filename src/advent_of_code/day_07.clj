(ns advent-of-code.day-07
  (:require [clojure.string :as str]))

(defn usr-command [s] 
  (let [[_ command arg] (str/split s #" +")]
    { :command command :arg arg}))

(defn dirent [s]
  (let [[command arg] (str/split s #" +")]
    (if (= command "dir")
        {:size 0 :name arg}
        {:size (Long/parseLong command) :name arg })))

(defn into-tree [_lines]
  (loop [[fst & rst] (next _lines) 
         dirpath ["/"]
         tree {}]
    (if (zero? (count rst))
        tree
        (cond 
           (= "ls" (fst :command)) (let [entries (vec (take-while #(some? (:size %)) rst)) 
                                         centries (count entries)]
                                     (recur (drop centries rst) dirpath
                                            (update-in tree dirpath (fn [dest] {:size (reduce + (map :size entries)) 
                                                                                      :parent (->> dirpath pop peek)} ))))
           (= "cd" (fst :command)) (let [dest (:arg fst)]
                                      (if (= ".." dest)
                                        (recur rst (pop dirpath) tree)
                                        (let [curdir (peek dirpath)]
                                          (recur rst (conj dirpath dest) tree))))))))
(defn parse-output [lines] 
  (let [tree (->> lines (map #(if (str/starts-with? % "$") (usr-command %) (dirent %)))
                        into-tree)] 
     (tree-seq map? identity tree)))
(defn part-1
  "Day 07 Part 1"
  [input]
  (->> (clojure.string/split-lines input)
       (parse-output)))

(let [input (slurp "./resources/day-07-example.txt")]
  (part-1 input))

(reduce (fn [acc [k v]] (println k)) {:a 1 :b 5})

(defn part-2
  "Day 07 Part 2"
  [input]
  input)
