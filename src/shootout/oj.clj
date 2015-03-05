(ns shootout.oj
  (:use shootout.config)
  (:require [oj.core :as oj]
            [clojure.string :as str]))

(defn get-user-groups [username]
  (let [user (first (oj/exec {:table :shootout.users
                              :where {:username username}} db))
        group-ids (oj/exec {:table :shootout.users_groups
                            :where {:user_id (:id user)}} db)
        groups (map #(first (oj/exec {:table :shootout.groups
                                      :where {:id (:group_id %)}} db))
                       group-ids)]
    (assoc user :groups groups)))
