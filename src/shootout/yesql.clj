(ns shootout.yesql
  (:use shootout.config)
  (:require [yesql.core :refer [defquery]]
            [shootout.util :refer :all]
            [clojure.string :as str]))

(defquery users-groups "shootout/yesql/get_users.sql")

(defn get-user-groups [username]
  (create-user-map 
    (users-groups db username)))
