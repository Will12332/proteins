(ns final.year.proteins-test
    (:use [clojure.test])
    (:require
     [final.year.proteins :as ont]
     [tawny.owl :as o]
     [tawny.reasoner :as r]
     [tawny.fixture :as f]))

(use-fixtures :each (f/reasoner :hermit))

(deftest reasonable
  (is (r/consistent? final.year.proteins/final-year-proteins))
  (is (r/coherent? final.year.proteins/final-year-proteins)))
