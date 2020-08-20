package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock

class GenDomainModelExtensions {
	def domainBlocks(GenDomainModel model) {
	    model.elements.filter(typeof(GenDomainBlock))
	}
}