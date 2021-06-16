db.people.insert({
  sex: 'Male',
  first_name: 'Eryk',
  last_name: 'Dzierzkowski',
  job: 'Developer',
  email: 'eryk.dzierzkowski123@gmail.com',
  location: {
    city: 'Plock',
    address: { streetname: 'Padlewskiego', streetnumber: '7' }
  },
  description: "4 z cwiczen to moje marzenie",
  height: 183,
  weight: 84,
  birth_date: '1997-06-03T09:24:14Z',
  nationality: 'Poland',
  credit: [
    {
      type: 'visa',
      number: '553213121591962',
      currency: 'PLN',
      balance: '1000'
    }
  ]
});
