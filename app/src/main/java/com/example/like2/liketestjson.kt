
//type
    data class liketestjson(
        val name: String,
        val code: String,
        val ID: String,
        val message: String,
        val url: Array<picurl>
    )
    data class picurl(
        val IDname:String
    )

    data class array(
        val Array : Array<liketestjson>
    )



