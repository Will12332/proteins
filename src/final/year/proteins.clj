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
    :comment "Kinetochore protein MHF1, CENP-S ortholog"
    :comment "https://www.pombase.org/gene/SPBC2D10.16")
  (defclass MHF2
    :comment "Kinetochore protein MHF2, CENP-X ortholog"
    :comment "https://www.pombase.org/gene/SPCC576.12c")
  (defclass CBH1
    :comment "Kinetochore protein CBH1, CENP-B homolog"
    :comment "https://www.pombase.org/gene/SPAC9E9.10c")
  (defclass CNP3
    :comment "Kinetochore protein CNP3, CENP-C ortholog"
    :comment "https://www.pombase.org/gene/SPBC1861.01c")
  (defclass FTA1
    :comment "Kinetochore protein FTA1, CENP-L ortholog"
    :comment "https://www.pombase.org/gene/SPAC4F10.12")
  (defclass MAL2
    :comment "Kinetochore protein MAL2, CENP-O ortholog"
    :comment "https://www.pombase.org/gene/SPAC25B8.14")
  (defclass MIS6
    :comment "Kinetochore protein MIS6, CENP-I ortholog"
    :comment "https://www.pombase.org/gene/SPAC1687.20c")
  (defclass MIS15
    :comment "Kinetochore protein MIS15, CENP-N ortholog"
    :comment "https://www.pombase.org/gene/SPBP22H7.09c")
  (defclass MIS16
    :comment "Kinetochore protein MIS16"
    :comment "https://www.pombase.org/gene/SPCC1672.10")
  (defclass MIS17
    :comment "Kinetochore protein MIS17, CENP-U ortholog"
    :comment "https://www.pombase.org/gene/SPBC21.01")
  (defclass MIS18
    :comment "Kinetochore protein MIS18"
    :comment "https://www.pombase.org/gene/SPCC970.12")
  (defclass SIM4
    :comment "Kinetochore protein SIM4, CENP-K ortholog"
    :comment "https://www.pombase.org/gene/SPBC18E5.03c"))

;;Add Bindings between Proteins

(defoproperty binds)

(owl-class MHF1
  :comment "https://www.pombase.org/reference/PMID:28977643"
  :super
  (owl-some binds MHF2))

(owl-class MHF2
  :comment "https://www.pombase.org/reference/PMID:28977643"
  :super
  (owl-some binds MHF1))

(owl-class CNP3
  :comment "https://www.pombase.org/reference/PMID:19758558"
  :super
  (owl-some binds FTA1))

(owl-class FTA1
  :comment "https://www.pombase.org/reference/PMID:19758558"
  :super
  (owl-some binds CNP3))

(owl-class MIS6
  :comment "https://www.pombase.org/reference/PMID:15369671"
  :super
  (owl-some binds MIS15)
  (owl-some binds MIS16))

(owl-class MIS6
  :comment "https://www.pombase.org/reference/PMID:12719471"
  :super
  (owl-some binds SIM4))

(owl-class MIS15
  :comment "https://www.pombase.org/reference/PMID:15369671"
  :super
  (owl-some binds MIS6)
  (owl-some binds MIS17))

(owl-class MIS16
  :comment "https://www.pombase.org/reference/PMID:15369671"
  :super
  (owl-some binds MIS18))

(owl-class MIS17
  :comment "https://www.pombase.org/reference/PMID:15369671"
  :super
  (owl-some binds MIS6)
  (owl-some binds MIS15))

(owl-class MIS18
  :comment "https://www.pombase.org/reference/PMID:15369671"
  :super
  (owl-some binds MIS16))

(owl-class SIM4
  :comment "https://www.pombase.org/reference/PMID:12719471"
  :super
  (owl-some binds MIS6))

;;Define a Role Hierarchy within my model

(defclass ProteinRole)

(defoproperty hasRole
  :domain Protein
  :range ProteinRole)

(p/deftier Role
  [ProteinBinding NucleicAcidBinding MetalIonBinding]
  :comment "First tier of roles in my hierarchy"
  :function false
  :domain Protein
  :suffix true
  :superproperty hasRole)

(p/deftier NucleicAcidBinding
  [DNABinding mRNABinding]
  :comment "Second tier of roles under Nucleic Acid Binding"
  :function false
  :domain Protein
  :suffix true
  :superproperty hasRole)

(p/deftier DNABinding
  [DoubleStranded Centromeric]
  :comment "Third tier of roles under DNA Binding"
  :function false
  :domain Protein
  :suffix true
  :superproperty hasRole)

;;Adding Roles to the Proteins

(owl-class Protein
  :super
  (owl-some hasRole ProteinBindingRole))

(owl-class MHF1
  :super
  (owl-some hasRole DoubleStrandedDNABinding)
  :comment "https://www.pombase.org/reference/PMID:20347428")

(owl-class MHF2
  :super
  (owl-some hasRole DoubleStrandedDNABinding)
  :comment "https://www.pombase.org/reference/PMID:20347428")

(owl-class CBH1
  :super
  (owl-some hasRole CentromericDNABinding)
  :comment "https://www.pombase.org/reference/PMID:9237993")

(owl-class CNP3
  :super
  (owl-some hasRole CentromericDNABinding)
  :comment "https://www.pombase.org/reference/PMID:15791413")

(owl-class MIS6
  :super
  (owl-some hasRole mRNABindingNucleicAcidBinding)
  :comment "")

(owl-class MIS18
  :super
  (owl-some hasRole MetalIonBindingRole)
  :comment "")

(owl-class SIM4
  :super
  (owl-some hasRole mRNABindingNucleicAcidBinding)
  :comment "")

;;Defining some Properties for the Proteins

(defclass ProteinProperty)

(p/defpartition ResidueLength
  [Small Medium Large]
  :comment "The number of Amino Acid residues"
  :comment "Small < 200; Medium > 200 && < 500; Large > 500"
  :super ProteinProperty
  :domain Protein)

;; Add Residue Length to Proteins

(owl-class MHF1
  :super
  (owl-some hasResidueLength Small)
  :comment "110")

(owl-class MHF2
  :super
  (owl-some hasResidueLength Small)
  :comment "89")

(owl-class CBH1
  :super
  (owl-some hasResidueLength Small)
  :comment "414")

(owl-class CNP3
  :super
  (owl-some hasResidueLength Large)
  :comment "643")

(owl-class FTA1
  :super
  (owl-some hasResidueLength Medium)
  :comment "280")

(owl-class MAL2
  :super
  (owl-some hasResidueLength Medium)
  :comment "303")

(owl-class MIS6
  :super
  (owl-some hasResidueLength Large)
  :comment "672")

(owl-class MIS15
  :super
  (owl-some hasResidueLength Medium)
  :comment "409")

(owl-class MIS16
  :super
  (owl-some hasResidueLength Medium)
  :comment "430")

(owl-class MIS17
  :super
  (owl-some hasResidueLength Medium)
  :comment "441")

(owl-class MIS18
  :super
  (owl-some hasResidueLength Small)
  :comment "194")

(owl-class SIM4
  :super
  (owl-some hasResidueLength Medium)
  :comment "277")
