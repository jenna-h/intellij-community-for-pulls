// "Make 'foo' protected" "true"

open class A {
    private val foo = 1
}

class B : A() {
    fun bar() {
        <caret>foo
    }
}
// FUS_QUICKFIX_NAME: org.jetbrains.kotlin.idea.quickfix.ChangeVisibilityFix$ChangeToProtectedFix
// FUS_K2_QUICKFIX_NAME: org.jetbrains.kotlin.idea.k2.codeinsight.fixes.ChangeVisibilityFixFactories$ChangeToProtectedModCommandAction