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

(owl-class MHF1
  :comment ""
  :super
  (owl-some binds MHF2))

(owl-class MHF2
  :comment ""
  :super
  (owl-some binds MHF1))

(owl-class CNP3
  :comment ""
  :super
  (owl-some binds FTA1))

(owl-class FTA1
  :comment ""
  :super
  (owl-some binds CNP3))

(owl-class MIS6
  :comment ""
  :super
  (owl-some binds MIS15)
  (owl-some binds MIS16))


(owl-class MIS6
  :comment ""
  :super
  (owl-some binds SIM4))

(owl-class MIS15
  :comment ""
  :super
  (owl-some binds MIS6)
  (owl-some binds MIS17))

(owl-class MIS16
  :comment ""
  :super
  (owl-some binds MIS18))

(owl-class MIS17
  :comment ""
  :super
  (owl-some binds MIS6)
  (owl-some binds MIS15))

(owl-class MIS18
  :comment ""
  :super
  (owl-some binds MIS16))

(owl-class SIM4
  :comment ""
  :super
  (owl-some binds MIS6))





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

