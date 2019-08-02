<#import "parts/common.ftl" as common>
<@common.page/>
    <div>Hello, User!</div>
<div>The init list</div>
<#list start as now>
    <span>${now}</span>
    <span>  </span>
</#list>
<div>filter</div>
<h5>${filter}</h5>
<div>distinct</div>
<#list distinct as sequence>
    <span>${sequence}</span>
    <span>  </span>
</#list>
<div>flatMap</div>
<#list flatMap as sequence>
    <span>${sequence}</span>
    <span>  </span>
</#list>
<div>limit</div>
<#list limit as sequence>
    <span>${sequence}</span>
    <span>  </span>
</#list>

<div>sorted</div>
<#list sorted as sequence>
    <span>${sequence}</span>
    <span>  </span>
</#list>

<div>peek</div>
<#list peek as sequence>
    <span>${sequence}</span>
    <span>  </span>
</#list>

<div>map</div>
<#list map as sequence>
    <span>${sequence}</span>
    <span>  </span>
</#list>

<div>skip</div>
<#list skip as sequence>
    <span>${sequence}</span>
    <span>  </span>
</#list>











