(ns webscrapper.core
  (:gen-class)
  (:require [net.cgrand.enlive-html :as html]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(println "hello")

(def patagonia-url "https://www.patagonia.com/store-locator/")


(html/html-resource (java.net.URL patagonia-url))