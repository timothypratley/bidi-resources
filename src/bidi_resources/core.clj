(ns bidi-resources.core
  (:require
   [ring.util.response :refer [response resource-response]]
   [ring.middleware.content-type :refer (wrap-content-type)]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
   [bidi.bidi :as bidi]
   [bidi.ring :refer [make-handler resources]]))

(def my-routes ["/" [["hello" (fn [req] (response "Hello to you too"))]
                     ["" (resources {:prefix "public/"})]]])

(prn "***" (bidi/match-route my-routes "/index.html"))

(def handler
  (wrap-defaults (make-handler my-routes) site-defaults))
