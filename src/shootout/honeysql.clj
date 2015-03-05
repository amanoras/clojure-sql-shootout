(ns shootout.honeysql
  (:use shootout.config)
  (:require [honeysql.core :as sql]
            [honeysql.helpers :refer :all]
            [clojure.java.jdbc :as jdbc]
            [shootout.config :refer :all]
            [clojure.string :as str]))

(defn get-user-groups [username]
  (jdbc/query db
    (sql/format
      {:select [:*]
       :from [[:shootout.users :u]]
       :join [[:shootout.users_groups :ug] [:= :u.id :ug.user_id] 
              [:shootout.groups :g] [:= :g.id :ug.group_id]]
       :where [:= :u.username username]})))
