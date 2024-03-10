(ns webscrapper.core
  (:gen-class)
  (:require [net.cgrand.enlive-html :as html]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(println "hello")

(def patagonia-url "https://www.patagonia.com/store-locator/")

(slurp patagonia-url)

;; https://github.com/practicalli/webscraper/blob/master/src/practicalli/webscraper_enlive.clj

(defn website-content
  "Get website content from a given URL

  Arguments: web address as a string
  Returns: list of html content as hash-maps"

  [website-url]

  (html/html-resource (java.net.URL. website-url)))

#_(website-content patagonia-url)


(def website-content-patagonia-stores
  "Get website content from Patagonia Store Locator
  Returns: list of html content as hash-maps"

  (html/html-resource (java.net.URL. patagonia-url)))

(clojure.pprint/pprint website-content-patagonia-stores)

(html/select
  website-content-patagonia-stores
  [:div.store-locator__state-container])


(take 1
      (html/select
        website-content-patagonia-stores
        [:div.store-locator__state-container]))

;; Get List of states that we have.
(map html/text
     (html/select
       website-content-patagonia-stores
       [:h2.store-locator__state-heading]))