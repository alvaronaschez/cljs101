(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'clojurescript-project.core
   :output-to "out/clojurescript_project.js"
   :output-dir "out"})
