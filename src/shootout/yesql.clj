(ns shootout.yesql
  (:use shootout.config)
  (:require [yesql.core :refer [defquery]]
            [clojure.string :as str]))

(defquery users-groups "shootout/yesql/get_users.sql")

(defn get-user-groups [username]
  (users-groups db username))

(defn get-user-groups [username]
  (users-groups db username))
