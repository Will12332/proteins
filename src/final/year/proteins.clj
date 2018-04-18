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

(as-subclasses
  Protein
  :disjoint
  (defclass MHF1
    :label "Kinetochore protein MHF1, CENP-S ortholog"
    :label "https://www.pombase.org/gene/SPBC2D10.16")
  (defclass MHF2
    :label "Kinetochore protein MHF2, CENP-X ortholog"
    :label "https://www.pombase.org/gene/SPCC576.12c")
  (defclass CBH1
    :label "Kinetochore protein CBH1, CENP-B homolog"
    :label "https://www.pombase.org/gene/SPAC9E9.10c")
  (defclass CNP3
    :label "Kinetochore protein CNP3, CENP-C ortholog"
    :label "https://www.pombase.org/gene/SPBC1861.01c")
  (defclass FTA1
    :label "Kinetochore protein FTA1, CENP-L ortholog"
    :label "https://www.pombase.org/gene/SPAC4F10.12")
  (defclass MAL2
    :label "Kinetochore protein MAL2, CENP-O ortholog"
    :label "https://www.pombase.org/gene/SPAC25B8.14")
  (defclass MIS6
    :label "Kinetochore protein MIS6, CENP-I ortholog"
    :label "https://www.pombase.org/gene/SPAC1687.20c")
  (defclass MIS15
    :label "Kinetochore protein MIS15, CENP-N ortholog"
    :label "https://www.pombase.org/gene/SPBP22H7.09c")
  (defclass MIS16
    :label "Kinetochore protein MIS16"
    :label "https://www.pombase.org/gene/SPCC1672.10")
  (defclass MIS17
    :label "Kinetochore protein MIS17, CENP-U ortholog"
    :label "https://www.pombase.org/gene/SPBC21.01")
  (defclass MIS18
    :label "Kinetochore protein MIS18"
    :label "https://www.pombase.org/gene/SPCC970.12")
  (defclass SIM4
    :label "Kinetochore protein SIM4, CENP-K ortholog"
    :label "https://www.pombase.org/gene/SPBC18E5.03c"))

(defoproperty binds)

(owl-class CENP-A
  :super
  (owl-some binds NDC-80))


