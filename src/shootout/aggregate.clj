(ns shootout.aggregate
  (:use shootout.config)
  (:require [aggregate.core :as agg]
            [shootout.config :refer :all]
            [clojure.string :as str]))

(def er-conf
  (agg/make-er-config
    (agg/entity :shootout.users
      (agg/->mn :groups :shootout.groups 
        {:query-fn (agg/make-query-<many>-fn
                     :shootout.groups
                     :shootout.users_groups
                     :user_id
                     :group_id)}))
    (agg/entity :shootout.groups
      (agg/->mn :users :shootout.users 
        {:query-fn (agg/make-query-<many>-fn
                     :shootout.users
                     :shootout.users_groups
                     :group_id
                     :user_id)})))) 

(defn create-user-map [user] 
  (hash-map :id (:id user)
            :username (:username user)
            :password (:password user)
            :groups (map #(hash-map :id (:id %)
                                     :name (:name %)) (:groups user))))

(defn get-user-groups [id]
  (create-user-map (agg/load er-conf db :shootout.users id)))
