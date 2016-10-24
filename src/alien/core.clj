(ns alien.core
  (:gen-class)
  (require clojure.string))

(defn to-native [{:keys [value table]}]
  (let [base (count table)]
    (map-indexed (fn [c index] (* (clojure.string/index-of table c) (bigint (Math/pow base index))))) value))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (to-native {:value "110" :table "0123456789"}) 
  (println "Hello, World!"))
