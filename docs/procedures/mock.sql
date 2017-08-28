DELIMITER ¤
CREATE PROCEDURE populateDatabase()
BEGIN
  SET @maxGS = 10;
  SET @gsIterator = 0;

  REPEAT
    SET @gsName = CONCAT('Game System ', @gsIterator);
    SET @gsShortName = CONCAT('GS_', @gsIterator);
    INSERT INTO `game_system`(`name`, `short_name`, `website`, `mediaId`) VALUES ( @gsName, @gsShortName, NULL, NULL);
    SET @gsIterator = @gsIterator +1;
  UNTIL @gsIterator > @maxGS END REPEAT;
END ¤
DELIMITER ;

DELIMITER ¤
CREATE PROCEDURE createUniverses()
BEGIN
  SET @maxUniverse = 20;
  SET @uIterator = 0;
  REPEAT
    SET @creationTime = CURRENT_TIMESTAMP();
    SET @uDescription = CONCAT('Description of Universe ', @uIterator);
    SET @uName        = CONCAT('Universe ', @uIterator);
    INSERT INTO `universe` (`creation_time`, `description`, `name`, `mediaId`) VALUES (@creationTime, @uDescription, @uName, NULL);
    SET @uIterator = @uIterator +1;
  UNTIL @uIterator > @maxUniverse END REPEAT;
END ¤
DELIMITER ;

DELIMITER ¤
CREATE PROCEDURE createPortages()
BEGIN

END ¤
DELIMITER ;