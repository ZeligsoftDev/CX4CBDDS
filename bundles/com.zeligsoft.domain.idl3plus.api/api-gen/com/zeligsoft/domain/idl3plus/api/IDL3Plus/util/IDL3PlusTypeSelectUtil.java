package com.zeligsoft.domain.idl3plus.api.IDL3Plus.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.PackageableElement;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;

import com.zeligsoft.domain.idl3plus.api.IDL3Plus.IDL3PlusModel;
import com.zeligsoft.domain.idl3plus.api.IDL3Plus.ExtendedPortType;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorFragment;
import com.zeligsoft.domain.idl3plus.api.Connectors.FragmentImplementation;
import com.zeligsoft.domain.idl3plus.api.Connectors.FragmentAssembly;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorImplementation;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorAssembly;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDefaultValueBinding;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule;
import com.zeligsoft.domain.idl3plus.api.Generics.ModuleInstantiation;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateParameterType;

public class IDL3PlusTypeSelectUtil {
    public List<IDL3PlusModel> selectIDL3PlusModel(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::IDL3Plus::IDL3PlusModel"));
        final Collection<IDL3PlusModel> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(IDL3PlusModel.class));
        return new ImmutableList.Builder<IDL3PlusModel>().addAll(result).build();
        
    }
    
    public List<ExtendedPortType> selectExtendedPortType(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::IDL3Plus::ExtendedPortType"));
        final Collection<ExtendedPortType> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(ExtendedPortType.class));
        return new ImmutableList.Builder<ExtendedPortType>().addAll(result).build();
        
    }
    
    public List<ConnectorDef> selectConnectorDef(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Connectors::ConnectorDef"));
        final Collection<ConnectorDef> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(ConnectorDef.class));
        return new ImmutableList.Builder<ConnectorDef>().addAll(result).build();
        
    }
    
    public List<ConnectorFragment> selectConnectorFragment(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Connectors::ConnectorFragment"));
        final Collection<ConnectorFragment> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(ConnectorFragment.class));
        return new ImmutableList.Builder<ConnectorFragment>().addAll(result).build();
        
    }
    
    public List<FragmentImplementation> selectFragmentImplementation(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Connectors::FragmentImplementation"));
        final Collection<FragmentImplementation> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(FragmentImplementation.class));
        return new ImmutableList.Builder<FragmentImplementation>().addAll(result).build();
        
    }
    
    public List<FragmentAssembly> selectFragmentAssembly(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Connectors::FragmentAssembly"));
        final Collection<FragmentAssembly> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(FragmentAssembly.class));
        return new ImmutableList.Builder<FragmentAssembly>().addAll(result).build();
        
    }
    
    public List<ConnectorImplementation> selectConnectorImplementation(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Connectors::ConnectorImplementation"));
        final Collection<ConnectorImplementation> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(ConnectorImplementation.class));
        return new ImmutableList.Builder<ConnectorImplementation>().addAll(result).build();
        
    }
    
    public List<ConnectorAssembly> selectConnectorAssembly(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Connectors::ConnectorAssembly"));
        final Collection<ConnectorAssembly> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(ConnectorAssembly.class));
        return new ImmutableList.Builder<ConnectorAssembly>().addAll(result).build();
        
    }
    
    public List<ConnectorDefaultValueBinding> selectConnectorDefaultValueBinding(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Connectors::ConnectorDefaultValueBinding"));
        final Collection<ConnectorDefaultValueBinding> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(ConnectorDefaultValueBinding.class));
        return new ImmutableList.Builder<ConnectorDefaultValueBinding>().addAll(result).build();
        
    }
    
    public List<TemplateModule> selectTemplateModule(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Generics::TemplateModule"));
        final Collection<TemplateModule> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(TemplateModule.class));
        return new ImmutableList.Builder<TemplateModule>().addAll(result).build();
        
    }
    
    public List<ModuleInstantiation> selectModuleInstantiation(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Generics::ModuleInstantiation"));
        final Collection<ModuleInstantiation> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(ModuleInstantiation.class));
        return new ImmutableList.Builder<ModuleInstantiation>().addAll(result).build();
        
    }
    
    public List<TemplateParameterType> selectTemplateParameterType(org.eclipse.uml2.uml.Package pkg) {
        final Collection<PackageableElement> elements = 
            Collections2.filter(pkg.getPackagedElements(),
                new IsZDLConcept("IDL3Plus::Generics::TemplateParameterType"));
        final Collection<TemplateParameterType> result = 
            Collections2.transform(elements, CreateZDLWrapper.create(TemplateParameterType.class));
        return new ImmutableList.Builder<TemplateParameterType>().addAll(result).build();
        
    }
    
}
