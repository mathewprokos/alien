(ns alien.core
  (:gen-class)
  (require clojure.string))

(defn logn [base n]
  (/ (Math/log n) (Math/log base)))

(defn to-native [{:keys [value table]}]
  (let [base (count table)]
    (map-indexed (fn [c index] (* (clojure.string/index-of table c) (bigint (Math/pow base index))))) value))

(defn to-alien [{:keys [value table]}]
  1)

(defn num-logs
  ([value base] (num-logs value base 0)) 
  ([value base total]
   (if (<= value 1)
     total
     (let [v (bigint (logn base value))]
       (println value base total)
       (num-logs (- value v) base (+ value v))))))

(defn -main
  [& args]
  (to-native {:value "110" :table "0123456789"})
  (logn 2 1000)
  (num-logs 1000 2) 
  (println "Hello, World!"))
