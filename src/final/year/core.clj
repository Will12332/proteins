(ns final.year.core
  [:use [tawny.owl]]
  [:require [final.year.proteins]])


(defn -main [& args]
  (save-ontology final.year.proteins/final-year-proteins "final-year-proteins.omn"))
