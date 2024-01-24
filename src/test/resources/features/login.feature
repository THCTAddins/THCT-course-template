Feature: Login Feature

    Scenario: verify login success
        Given browser is opened
        When enter mail "lfl26900@zslsz.com"
        And enter pass "lfl26900@zslsz.com"
        And click submit
        Then verify login success