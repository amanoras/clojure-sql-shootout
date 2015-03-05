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

(defn get-user-groups [id]
  (agg/load er-conf db :shootout.users id))
