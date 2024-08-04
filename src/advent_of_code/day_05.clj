(ns advent-of-code.day-05
  (:require [clojure.string :as str])
  (:require [clojure.pprint :refer [ pprint]]))

(defn instructions [lines]
  ; mv x from y to z
  (->> (map #(re-seq #"\d+" %) lines)
       (map #(map read-string %))))

(defn parse-line [numcol line]
   (let [len (count line)]
    (->> (map (partial get line) (range 1 len 4)))))

(defn parse-chart [lines]
  (let [[numcol & data] lines
        num-stacks (count (re-seq #"\S+" numcol))]
        ;transpose matrix
        (->> (apply mapv vector (map (partial parse-line num-stacks) data))
             (map (fn [r] (filter #(not= \space %) r)))
             (map vec))))


(defn parse [lines]
   (loop [[fst nxt & rst] lines
           chart []] 
     (if (str/starts-with? (or nxt "move") "move")
          {:chart (vec (parse-chart (reverse chart)))  
           :instructions (instructions (cons nxt rst))}  
          (recur (cons nxt rst) (conj chart fst)))))

(defn transaction [topf dest]
  (reduce conj dest topf))

(defn interpret-instructions [chart instructions]
 (reduce (fn [acc [quant from dest]]
              (let [from-vec (acc (dec from)) 
                    [bottomf topf] (map vec (split-at (- (count from-vec) quant) from-vec))]
                (-> acc (assoc (dec from) bottomf)
                        ; if u wanna solve part 2, dont revert topf
                        (update (dec dest) (partial transaction (reverse topf ) ))))) 
            chart instructions ))
(defn part-1
  "Day 05 Part 1"
  [input]
  (let [{:keys [chart instructions]} (parse (str/split-lines input)) ]
    (->> (interpret-instructions chart instructions)
         (map last)
         )))

(defn part-2
  "Day 05 Part 2"
  [input]
  input)
