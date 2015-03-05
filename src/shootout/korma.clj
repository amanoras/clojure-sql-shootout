(ns shootout.korma
  (:use shootout.config)
  (:require [korma.core :refer [defentity many-to-many table select with where]]
            [korma.db :refer [defdb]]
            [shootout.config :refer :all]
            [clojure.string :as str]))

(declare user group)

(def korma-config
  (assoc db 
    :naming {:keys str/lower-case
             :fields str/upper-case}))

(defdb korma-db korma-config)

(defentity user
  (table "shootout.users")
  (many-to-many group :shootout.users_groups
    {:lfk "user_id"
     :rfk "group_id"}))

(defentity group
  (table "shootout.groups")
  (many-to-many user :shootout.users_groups
    {:lfk "group_id"
     :rfk "user_id"}))

(defn get-user-groups [username]
  (select user 
    (with group)
    (where {:username username})))
