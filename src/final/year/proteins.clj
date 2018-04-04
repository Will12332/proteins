(ns final.year.proteins
  (:use [tawny.owl]))


(defontology final-year-proteins
  :iri "http://example.com/final-year-proteins")

(defclass Protein)


(as-subclasses
  Protein
  :disjoint
  (defclass CENP-A)
  (defclass NDC-80)
  (defclass NUF-2)
  (defclass MIS-18)
  (defclass MIS-12)
  (defclass NSK-1)
  (defclass MIS-14)
  (defclass SPC-25)
  (defclass SPC-24)
  (defclass SOS-7)
  (defclass SPC-7)
  (defclass NNF-1))

