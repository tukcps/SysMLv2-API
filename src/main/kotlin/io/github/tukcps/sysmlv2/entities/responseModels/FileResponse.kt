package io.github.tukcps.sysmlv2.entities.responseModels


class FileResponse(
    var name: String,
    var url: String,
    var type: String,
    var size: Long,
    var id: String){
    // Just for Jackson deserialization ... constructor without parameters.
    private constructor(): this(name="", url="", type="",0, id="")
}