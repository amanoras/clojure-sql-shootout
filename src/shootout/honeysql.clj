(ns shootout.honeysql
  (:use shootout.config)
  (:require [honeysql.core :as sql]
            [honeysql.helpers :refer :all]
            [clojure.java.jdbc :as jdbc]
            [shootout.config :refer :all]
            [shootout.util :refer :all]
            [clojure.string :as str]))

(defn get-user-groups [username]
  (create-user-map  
    (jdbc/query db
      (sql/format
        {:select [[:u.id :user_id] :u.username :u.password :g.id :g.name]
         :from [[:shootout.users :u]]
         :join [[:shootout.users_groups :ug] [:= :u.id :ug.user_id] 
                [:shootout.groups :g] [:= :g.id :ug.group_id]]
         :where [:= :u.username username]}))))
