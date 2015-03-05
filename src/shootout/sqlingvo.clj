(ns shootout.sqlingvo
  (:use shootout.config)
  (:require [sqlingvo.core :as s]
            [sqlingvo.util :refer :all]
            [sqlingvo.db :refer [defdb]]
            [clojure.java.jdbc :as jdbc]
            [clojure.string :as str]))

(defdb h2
  "H2 database config"
  :classname (:classname db)
  :name sql-name-underscore
  :keyword sql-keyword-hyphenate
  :quote #(str/upper-case (sql-quote-double-quote %)))

(defn get-user-groups [username]
  (jdbc/query db
    (s/sql (s/select (h2) [*]
             (s/from :shootout.users)
             (s/join :shootout.users_groups 
               '(s/on (= :shootout.users.id :shootout.users_groups.user_id)))
             (s/join :shootout.groups
               '(s/on (= :shootout.groups.id :shootout.users_groups.group_id)))
             (s/where '(= :username username))))))
