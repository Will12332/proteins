(ns final.year.proteins
  (:use [tawny.owl]))


(defontology final-year-proteins
  :iri "http://example.com/final-year-proteins")

(defclass Protein)


(as-subclasses
  Protein
  :disjoint
  (defclass CENP-A
    :label "Centromere-specific histone H3 CENP-A"
    :label "https://www.pombase.org/gene/SPBC1105.17")
  (defclass NDC-80
    :label "NMS complex subunit NDC80"
    :label "https://www.pombase.org/gene/SPBC11C11.03")
  (defclass NUF-2
    :label "NMS complex subunit NUF2"
    :label "https://www.pombase.org/gene/SPAC27F1.04c")
  (defclass MIS-12
    :label "NMS complex subunit MIS12"
    :label "https://www.pombase.org/gene/SPBC409.04c")
  (defclass MIS-14
    :label "NMS complex subunit MIS14"
    :label "https://www.pombase.org/gene/SPAC688.02c")
  (defclass MIS-18
    :label "Kinetochore protein MIS18"
    :label "https://www.pombase.org/gene/SPCC970.12")
  (defclass SPC-24
    :label "NMS complex subunit SPC24"
    :label "https://www.pombase.org/gene/SPBC336.08")
  (defclass SPC-25
    :label "NMS complex subunit SPC25"
    :label "https://www.pombase.org/gene/SPCC188.04c")
  (defclass SOS-7
    :label "NMS complex subunit SOS7"
    :label "https://www.pombase.org/gene/SPAPB17E12.06")
  (defclass SPC-7
    :label "NMS complex subunit SPC7"
    :label "https://www.pombase.org/gene/SPCC1020.02")
  (defclass NNF-1)
  (defclass NSK-1))



(defoproperty binds)

(owl-class CENP-A
  :super
  (owl-some binds NDC-80))


