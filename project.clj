(defproject shootout "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main ^:skip-aot shootout.core
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.h2database/h2 "1.4.180"]
                 [korma "0.4.0"]
                 [aggregate "1.0.1"]
                 [honeysql "0.4.3"]
                 [oj "0.3.0"]
                 [sqlingvo "0.7.8"]
                 [yesql "0.4.0"]
                 [criterium "0.4.3"]]
  :aot :all
  :profiles
    {:production
     {}
     :dev
      {:dependencies [[midje "1.6.3"]]
           :plugins [[lein-midje "3.1.3"]]}})
