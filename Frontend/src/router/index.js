import Vue from 'vue'
import Router from 'vue-router'

import HomePage from '@/components/HomePage'
import LoginPage from '@/components/LoginPage'
import StudentPage from '@/components/Studentpage'
import SendNotif from '@/components/SendNotif'
import SignUpPage from '@/components/SignUpPage'
import ReviewPage from '@/components/ReviewPage'
import ContactPage from '@/components/ContactPage'
import ConfirmationPage from '@/components/ConfirmationPage'
import Courses from '@/components/Courses'
import ChooseTutors from '@/components/ChooseTutors'
import TutorAvailability from '@/components/TutorAvailability'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/studentpage',
      name: 'studentpage',
      component: StudentPage
    },
    {
      path: '/loginPage',
      name: 'LoginPage',
      component: LoginPage
    },
    {
      path: '/sendNotif',
      name: 'SendNotif',
      component: SendNotif
    },
    {
      path: '/courses',
      name: 'Courses',
      component: Courses
    },
    {
      path: '/courses',
      name: 'Courses',
      component: Courses
    },
    {
      path: '/reviewPage/',
      name: 'ReviewPage',
      component: ReviewPage
    },
    {
      path: '/courseSelection',
      name: 'Courses',
      component: Courses
    },
    {
      path: '/contactPage',
      name: 'ContactPage',
      component: ContactPage
    },
    {
      path: '/signUpPage',
      name: 'SignUpPage',
      component: SignUpPage
    },
    {
      path: '/confirmationPage',
      name: 'ConfirmationPage',
      component: ConfirmationPage
    },
        {
      path: '/courses',
      name: 'Courses',
      component: Courses
    },
    {
      path: '/chooseTutors',
      name: 'ChooseTutors',
      component: ChooseTutors
    },
    {
      path: 'tutorAvailability',
      name: 'TutorAvailability',
      component: TutorAvailability
    }
  ]
})
