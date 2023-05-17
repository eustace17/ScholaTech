package com.example.appdevelopmenttrialtwo

class Student {
    var name: String = ""
    var doa: String = ""
    var dob: String = ""
    var admno: String = ""
    var grade: String = ""
    var upi: String = ""
    var fname: String = ""
    var fcell: String = ""
    var fid: String = ""

    var mname: String = ""
    var mcell: String = ""
    var mid: String = ""


    constructor(
        name: String,
        doa: String,
        dob: String,
        admno: String,
        grade: String,
        upi: String,
        fname: String,
        fcell: String,
        fid: String,

        mname: String,
        mcell: String,
        mid: String,

    ) {
        this.name = name
        this.doa = doa
        this.dob = dob
        this.admno = admno
        this.grade = grade
        this.upi = upi
        this.fname = fname
        this.fcell = fcell
        this.fid = fid
        this.mname = mname
        this.mcell = mcell
        this.mid = mid

    }
    constructor()
}

