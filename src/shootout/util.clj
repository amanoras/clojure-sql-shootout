(ns shootout.util)

(defn create-user-map [groups]
  (let [group (first groups)]
    (hash-map :id (:user_id group)
              :username (:username group)
              :password (:password group)
              :groups (map #(hash-map :id (:id %)
                                      :name (:name %)) groups))))
