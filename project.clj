(defproject final-year-proteins "0.0.1-SNAPSHOT"
  :description "An ontology for final-year-proteins"
  :dependencies [[uk.org.russet/tawny-owl "2.0.0-SNAPSHOT"]]
  :main final.year.core

  :profiles
  {:light {:plugins [[nightlight/lein-nightlight "1.9.0"]]}}
  )
