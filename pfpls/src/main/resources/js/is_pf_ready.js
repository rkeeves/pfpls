return (document.readyState === 'complete')
        && (!window.jQuery || jQuery.active == 0)
        &&  (!window.PrimeFaces || !PrimeFaces.ajax || !PrimeFaces.ajax.Queue || PrimeFaces.ajax.Queue.isEmpty())