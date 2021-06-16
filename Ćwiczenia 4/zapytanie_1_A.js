db.people.aggregate([
  {
    $group: {
      _id: '$sex',
      totalWeight: { $sum: '$weight' },
      totalHeight: { $sum: '$height' },
      total: { $sum: 1 }
    }
  },
  {
    $project: {
      totalWeight: 1,
      totalHeight: 1,
      total: 1,
      averageWeight: {
        $divide: ['$totalWeight', '$total']
      },
      averageHeight: {
        $divide: ['$totalHeight', '$total']
      }
    }
  }
]);
