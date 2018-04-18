(ns final.year.proteins
  (:require 
     [clojure.string]
     [tawny.owl :refer :all]
     [tawny.pattern :as p]
     [tawny.reasoner :as r]
     [tawny.util :as u]))     
            


(defontology final-year-proteins
  :iri "http://example.com/final-year-proteins")

(defclass Protein)

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


(defclass TestRole)

(defoproperty hasRole
  :domain Protein
  :range TestRole)

(owl-class Protein
  :super (owl-some hasRole TestRole))

(defclass ProteinProperty)

(defmacro defroles
  [name values]
  `(p/deftier ~name ~values
    :suffix :Role
    :function false
    :cover false
    :domain Protein
    :superproperty hasRole))


(defroles TestRole
  [ProteinBinding DNABinding])

(p/deftier DNABinding
  [DoubleStranded Centromeric]
  :function false
  :cover false
  :domain Protein
  :suffix true
  :superproperty hasRole)

(p/defpartition CellCycleStage
  [G1 S G2 Mitotic]
  :comment "What stage of the Cell Cycle they bind"
  :super ProteinProperty
  :domain Protein)

(defmacro defaaproperty [& body]
  `(p/defpartition
    ~@body :super ProteinProperty
    :domain Protein))

(defaaproperty Essentialness
  [Essential NonEssential])

