(ns clojurescript-project.core
  (:require [clojure.browser.repl :as repl]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(println "Hello world!")

(defn getCurrentTime []
  (let [now (js/Date.)
        tz "America/New_York"
        now (. now toLocaleString "EN-us" #js{:timeZone tz})]
    now))

(-> js/document
    (.getElementById "test")
    (.-innerHTML)
    (set! (getCurrentTime))) ;