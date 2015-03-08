(ns shootout.cljjdbc
  (:use shootout.config)
  (:require [clojure.java.jdbc :as sql]
            [shootout.config :refer :all]
            [shootout.util :refer :all]
            [clojure.string :as str]))

(defn get-user-groups [username]
  (create-user-map
    (sql/query db ["select u.id as user_id, u.username, u.password, g.id, g.name from shootout.users as u join shootout.users_groups as ug on u.id = ug.user_id join shootout.groups as g on ug.group_id = g.id where u.username = ?" username])))
