
(require '[cheshire.core :refer :all])
(require '[clj-http.client :as client])

(defn read-json [path]
  (let [json-string (slurp path)]
    (parse-string json-string true)))

(defn print-all-old []
  (loop [cities  (read-json "/home/alvaro/workspace/clojurescript-project/worldcities.json")]
    (do
      (println (first cities))
      (let [tail (rest cities)]
        (if-not (empty? tail) (recur tail))))))

(defn print-all []
  (let [cities (read-json "/home/alvaro/workspace/clojurescript-project/worldcities.json")]
    (doseq [city cities]
      (println city))))

(defn add-tz [city tz]
  (assoc city :timeZone tz))

(defn normalize-json [json-string]
  ())

(defn process-cities []
  (let [cities (read-json "/home/alvaro/workspace/clojurescript-project/geonames-all-cities-with-a-population-1000.json")
        cities (filter #(> (get (get % :fields) :population) 100000) cities)]
    (println cities)))

(process-cities)
