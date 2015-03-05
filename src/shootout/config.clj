(ns shootout.config)

(def db
  {:classname   "org.h2.Driver"
   :subprotocol "h2"
   :subname "./resources/db/users.db"
   :user "sa"
   :password ""})
