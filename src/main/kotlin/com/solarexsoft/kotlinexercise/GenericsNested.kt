package com.solarexsoft.kotlinexercise


open class PracticeAnswerContent
class QuestionRunningData<T: PracticeAnswerContent>
abstract class PracticeQuestionRsp<Question: PracticeQuestion<
    out PracticeAnswerContent,
    out QuestionRunningData<out PracticeAnswerContent>,
    out PracticeQuestionRsp<Question>,
    Question
>>
abstract class PracticeQuestion<
    AnswerContent: PracticeAnswerContent,
    RunningData: QuestionRunningData<AnswerContent>,
    Rsp: PracticeQuestionRsp<Question>,
    Question: PracticeQuestion<AnswerContent, RunningData, Rsp, Question>
>

interface Hou<H: Hou<H,L>, L: Liu<L, H>>
interface Liu<L: Liu<L, H>, H: Hou<H, L>>