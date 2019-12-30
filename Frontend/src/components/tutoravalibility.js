export default {
  name: "TutorAvailability",
  props: ["email"],
  data() {
    return {
      availabilities: [],
      selectedAvailabilities: []
    };
  },
  async created() {
    localStorage.setItem(
      "selectedCourse",
      this.$route.params.course.name
    );
    try {
      const resAv = await axios.get(
        `http://localhost:8080/tutors/availabilities/` + this.email
      );
      this.availabilities = resAv.data;
    } catch (e) {
      console.error(e);
    }
  },

  methods: {
    SelectedInformation(tutor) {
      localStorage.setItem("SelectedTutorEmail", this.email);
      localStorage.setItem(
        "selectedDate",
        this.selectedAvailabilities[0].availableDate
      );
      localStorage.setItem(
        "selectedStartTime",
        this.selectedAvailabilities[0].startTime
      );
      localStorage.setItem(
        "selectedEndTime",
        this.selectedAvailabilities[0].endTime
      );
    }
  }
};