package com.thanh.ah.myapp.presenter

import com.thanh.ah.myapp.view.MainView

class MainPresenterImpl constructor(private val view: MainView) : MainPresenter {

    private lateinit var list: MutableList<String>


    private var mInput: String = ""

    private val hold = 50
    private val valueToDivide = 46

    override fun processInput(input: String) {
        // assign input to change it later
        mInput = input
        // make sure user does not input space at the end and begin of message.
        mInput.trim()
        // init list
        list = ArrayList()
        if (mInput.length <= hold) {
            // if message length < 50 then it easy
            list.add(mInput)
        } else {
            // else if the length is greater than 50 chars
            var initLength = mInput.length / hold
            val fixLength = input.length / valueToDivide + 1
            while (initLength in 0..9 && mInput.isNotEmpty()) {
                list.add(
                    (list.size + 1).toString() + "/" + fixLength + " " + chunkWord(
                        mInput
                    )
                )
                // 4 = space that index count "1/2 "
                mInput = mInput.substring(list.last().length - 4, mInput.length).trim()
                initLength = mInput.length / hold
            }
        }
        view.onShowList(list)
    }

    // return first 50 char as string base on the space index.
    private fun chunkWord(input: String): String {
        val index = valueToDivide
        if (input.length <= index) return input
        return input.substring(0, getIndexOfLastSpace(input))
    }

    // Return the last space index by moving backward the string.
    private fun getIndexOfLastSpace(string: String): Int {
        var preIndex = -1
        var middle = valueToDivide
        while (middle >= 0) {
            if (string[middle] == ' ') {
                preIndex = middle
                break
            } else {
                middle--
            }
        }
        return preIndex
    }
}